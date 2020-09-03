package com.smalaca.shipment.fakeapigateway.infrastructure.rest.order;

class OrderDto {
    private String id;
    private String name;
    private String address;

    OrderDto(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
