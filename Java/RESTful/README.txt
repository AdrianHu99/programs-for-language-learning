This project creates a REST API application - Messenger based on Java Brains' tutorial (https://www.youtube.com/watch?v=xkKcdK1u95s&index=1&list=PLqq-6Pq4lTTZh5U8RbdXq0WaYvZBz2rbn). In this project, JAX-RS interfaces and annotations are used with Jersey. I learned how the components handle the API requests (including return some data in different formats such as XML or JSON) and how they fit together.

08.24:

-Build a Messenger application using Maven and Jersey, created a model Message with Message Resource and Message Service.

08.25:

-Implemented CRUD(create, retrieve, update and delete) on messages and add another model Profile with Profile Resource and Profile Service.
-Created a database for storing messages and profiles.

08.26:

-Added parameters in the URI using @QueryParam("")
-Learned how to get parameters using annotations (@MatrixParam, @HeaderParam and @CookieParam)

08.27:

-Learned how to get parameters using context (@Context UriInfo/HttpHeaders)
-Learned how to use beans to get parameters instead of writing so many parameters in the method
-Learned how to write sub resource in the father resource
-Learned how to send status code and location headers by using Response instance
-How to handle exceptions

08.28:

-Learned WebApplicationException with its sub exceptions
-Learned HATEOAS (create links for messages and profiles)
-Learned how to change @Produces for Accepts and @Consumes for Content-Type




