package it.unical.asd.group6.computerSparePartsCompany.core.services;

import it.unical.asd.group6.computerSparePartsCompany.data.dto.JobRequestDTO;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.JobRequest;

import java.util.List;

public interface JobRequestService {

    public List<JobRequestDTO>getAll();
    public List<JobRequestDTO>getAllByTitle(String title);
    public List<JobRequestDTO>getAllByPosition(String position);
    public List<JobRequestDTO>getAllByEmail(String email);
    public Boolean insert(String title, String position, String date, String description, String email, String username);
    public Boolean delete(JobRequestDTO jobRequestDTO);
    public JobRequestDTO getByUsername(String username);

}
