package main.rpc04;

import common.IUserService;

import java.io.IOException;

public class Client {
    public static void main(String[] args) throws IOException {
        IUserService service = Stub.getStub();
        System.out.println(service.findUserById(123));
    }

}
