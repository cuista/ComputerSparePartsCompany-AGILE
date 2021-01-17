package it.unical.asd.group6.computerSparePartsCompany.core.services;

import it.unical.asd.group6.computerSparePartsCompany.data.dto.ErrorMessageDTO;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.ErrorMessage;

import java.util.List;

public interface ErrorMessageService {

    public Boolean insert(ErrorMessage errorMessage);
    public Boolean remove(ErrorMessage errorMessage);
    public List<ErrorMessageDTO> getAll();
    public ErrorMessageDTO getByUsername(String username);
}
