package it.unical.asd.group6.computerSparePartsCompany.core.services;

import it.unical.asd.group6.computerSparePartsCompany.data.dto.ErrorMessageDTO;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.ErrorMessage;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ErrorMessageService {

    public Boolean insert(String title, String description, String email, String username);
    public Boolean remove(String username);
    public List<ErrorMessageDTO> getAll();
    public ErrorMessageDTO getByUsername(String username);
}
