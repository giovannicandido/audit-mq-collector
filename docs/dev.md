# Dev environment

The quickest way to create a dev env is to use docker

I prefer to install postgresql as a native application on my dev machine.

You can use the docker-compose program to run the environment.

As I have postgresql instaled, I prefer to run rabbitmq in the command line:

    docker run -d --hostname my-rabbit --name rabbit -p 5672:5672 -p 4369:4369 -p 25672:25672 -p 15672:15672 rabbitmq:3
    
I really don't know why all this ports need to be open, maybe not all of them, but :-)