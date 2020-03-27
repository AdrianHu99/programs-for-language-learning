package org.adrian.messenger.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.adrian.messenger.model.Message;
import org.adrian.messenger.resources.beans.MessageFilterBean;
import org.adrian.messenger.service.MessageService;


//Map the URI to the class
@Path("/messages")
//Actually we can add consumes and produces here so that we don't need to add these before each method
public class MessageResource {
	
	
	//@GET maps the HTTP method to the class method
	//@Produces tells jersey what is the return content type
	/*@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getMessages(){
		return "Hello World!";
	}*/
	
	MessageService messageService = new MessageService();
	
	//Let jersey to get the list and convert it to xml format
	//If you want XML format, please type the URI on chrome, Eclipse will give you plain text!
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	//If you want to add a parameter in the URI (?year=2016), you can add another annotation;After we add this, 
	//if we don't write it in the URI, it will be 0
	public List<Message> getMessages(@BeanParam MessageFilterBean filterBean){
		if(filterBean.getYear() > 0){
			return messageService.getAllMessagesForYear(filterBean.getYear());
		}
		if(filterBean.getStart() >= 0 && filterBean.getSize() >  0){
			return messageService.getAllMessagesPaginated(filterBean.getStart(), filterBean.getSize());
		}
		return messageService.getAllMessages();
	}
	
	
	/*We can have method-level annotations for subsequent path
	Also we can use variable in the subsequent path*/
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	//If you want to add one more mediatype (e.x. XML), you can do:
	//@Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
	public Message getMessage(@PathParam("messageId") long messageId, @Context UriInfo uriInfo){
		//The parameter in the method is the one in the path, we did that by using @PathParam 
		//We don't need to worry the type conversion, Jersey will do that for us
		Message message = messageService.getMessage(messageId);
		message.addLink(getUriForSelf(uriInfo, message), "self");
		message.addLink(getUriForProfile(uriInfo, message), "profile");
		message.addLink(getUriForComments(uriInfo, message), "comments");
		return message;
	}

	private String getUriForComments(UriInfo uriInfo, Message message){
		URI uri = uriInfo.getBaseUriBuilder()
				.path(MessageResource.class)
				//Because comment is the sub resource of message, we need to add the method in 
				//MessageResource to get the path to the method
				.path(MessageResource.class, "getCommentResource")
				.path(CommentResource.class)
				//Use resolveTemplate to replace "messageId" to the real Id
				.resolveTemplate("messageId", message.getId())
				.build();
		return uri.toString();
	}
	
	private String getUriForProfile(UriInfo uriInfo, Message message){
		URI uri = uriInfo.getBaseUriBuilder()
				.path(ProfileResource.class)
				.path(message.getAuthor())
				.build();
		return uri.toString();
	}
	
	private String getUriForSelf(UriInfo uriInfo, Message message) {
		String uri = uriInfo.getBaseUriBuilder()
		.path(MessageResource.class)
		.path(Long.toString(message.getId()))
		.build()
		.toString();
		return uri;
	}
	
	/*We can also have multiple variables in the path:
	/something/{id1}/name/{id2}
	@PathParam("id1") int id1,
	@PathParam("id2") int id2*/
	
	
	
	
	//Now let's add a POST method
	
	@POST
	//Use @Consumes to specify the expected request body format (which is in the parameters)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	/*public Message addMessages(Message message){
		return messageService.addMessage(message);
	}*/
	//We can add the message and in the mean time change the status code by using response instance
	public Response addMessage(Message message, @Context UriInfo uriInfo) {
		Message newMessage = messageService.addMessage(message);
		String newId = String.valueOf(newMessage.getId());
		//By using getAblosutePathBuilder, we can add newId into the absolutePath
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
		//Instead of using status(Status.CREATED), using created("") will help you set the location also
		return Response.created(uri)
				.entity(newMessage)
				.build();
	}
	
	
	
	/*Notice that if you operate a put method on message 1 and 2, the database will remain the same as we 
	hard coded message 1 and 2. What we can do is to do it on message 3 or another message that was newly created.*/
	
	@PUT
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("messageId") long messageId, Message message){
		//Get the id from the URI
		message.setId(messageId);
		return messageService.updateMessage(message);
	}
	
	
	@DELETE
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteMessage(@PathParam("messageId") long messageId){
		messageService.removeMessage(messageId);
	}
	
	
	//Notice that there is no @GET because it could be used for POST,DELETE and PUT
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource(){
		//It will hand over the task to commentResource class
		return new CommentResource();
	}
}
