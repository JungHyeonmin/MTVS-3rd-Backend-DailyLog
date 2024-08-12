package com.ohgiraffers.restapi.section04.hateoas;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class DtoModelAssembler implements RepresentationModelAssembler<UserDTO, EntityModel<UserDTO>> {

    @Override
    public EntityModel<UserDTO> toModel(UserDTO dto) {

        return EntityModel.of(dto,
                linkTo(methodOn(HateoasTestController.class).findUserByUserNo(dto.getNo())).withSelfRel(),
                linkTo(methodOn(HateoasTestController.class).findAllUsers()).withRel("users")
        );
    }
}