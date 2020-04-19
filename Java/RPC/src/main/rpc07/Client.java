package main.rpc07;

import common.IProductService;
import common.IUserService;

import java.io.IOException;

public class Client {
    public static void main(String[] args) throws IOException {
        IProductService service = (IProductService) Stub.getStub(IProductService.class);
        System.out.println(service.findProductById(123));
    }

}
