package org.adrian.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.adrian.messenger.model.ErrorMessage;


//Provider for registering at JAX-RS so it will know the class is there
@Provider
//This could be used for any exception, we only need to know the class and which exception should be caught
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException ex) {
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 404, "https://github.com/adrrrrrrrian");
		return Response.status(Status.NOT_FOUND)
				.entity(errorMessage)
				.build();
	}

}
