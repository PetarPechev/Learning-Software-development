package com.company.oop.dealership.models.vehicles.contracts;

import com.company.oop.dealership.models.contracts.Comment;
import com.company.oop.dealership.models.contracts.Commentable;
import com.company.oop.dealership.models.contracts.Priceable;
import com.company.oop.dealership.models.vehicles.enums.VehicleType;

public interface Vehicle extends Commentable, Priceable {

    int getWheels();

    VehicleType getType();

    String getMake();

    String getModel();

    void addComment(Comment comment);

    void removeComment(Comment comment);

}
