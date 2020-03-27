## Start a GCC instance running your app

https://hub.docker.com/_/gcc

The most straightforward way to use this image is to use a gcc container as both the build and runtime environment. In your Dockerfile, writing something along the lines of the following will compile and run your project:

FROM gcc:4.9
COPY . /usr/src/myapp
WORKDIR /usr/src/myapp
RUN gcc -o myapp main.c
CMD ["./myapp"]
Then, build and run the Docker image:

$ docker build -t my-gcc-app .
$ docker run -it --rm --name my-running-app my-gcc-app
