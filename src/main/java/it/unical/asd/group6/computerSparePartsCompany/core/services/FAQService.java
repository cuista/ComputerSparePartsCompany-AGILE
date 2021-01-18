package it.unical.asd.group6.computerSparePartsCompany.core.services;

import it.unical.asd.group6.computerSparePartsCompany.data.dto.FAQDTO;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.FAQ;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Review;

import java.util.List;
import java.util.Optional;

public interface FAQService {

    public Boolean insert(String title, String text);
    public List<FAQDTO>getAll();
    public FAQ getByTitle(String title);
    public FAQDTO getByDescription(String description);
    public Boolean remove(FAQ f);
    Boolean delete(FAQ r);
    Boolean deleteAll();
}
