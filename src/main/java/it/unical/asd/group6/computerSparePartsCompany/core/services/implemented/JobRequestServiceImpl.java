package it.unical.asd.group6.computerSparePartsCompany.core.services.implemented;

import it.unical.asd.group6.computerSparePartsCompany.core.services.JobRequestService;
import it.unical.asd.group6.computerSparePartsCompany.data.dao.JobRequestDAO;
import it.unical.asd.group6.computerSparePartsCompany.data.dto.FAQDTO;
import it.unical.asd.group6.computerSparePartsCompany.data.dto.JobRequestDTO;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.FAQ;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.JobRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.JoinTable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobRequestServiceImpl implements JobRequestService {

    @Autowired
    JobRequestDAO jobRequestDAO;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<JobRequestDTO> getAll() {
        Optional<List<JobRequest>> jobRequests = jobRequestDAO.getAll();
        if(jobRequests.isPresent())
        {
            List<JobRequest>fs = jobRequests.get();
            return fs.stream().map(cat -> modelMapper.map(cat, JobRequestDTO.class)).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    @Override
    public List<JobRequestDTO> getAllByTitle(String title) {
        Optional<List<JobRequest>> jobRequests = jobRequestDAO.getAllByTitle(title);
        if(jobRequests.isPresent())
        {
            List<JobRequest>fs = jobRequests.get();
            return fs.stream().map(cat -> modelMapper.map(cat, JobRequestDTO.class)).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    @Override
    public List<JobRequestDTO> getAllByPosition(String position) {
        Optional<List<JobRequest>> jobRequests = jobRequestDAO.getAllByPosition(position);
        if(jobRequests.isPresent())
        {
            List<JobRequest>fs = jobRequests.get();
            return fs.stream().map(cat -> modelMapper.map(cat, JobRequestDTO.class)).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    @Override
    public List<JobRequestDTO> getAllByEmail(String email) {
        Optional<List<JobRequest>> jobRequests = jobRequestDAO.getAllByEmail(email);
        if(jobRequests.isPresent())
        {
            List<JobRequest>fs = jobRequests.get();
            return fs.stream().map(cat -> modelMapper.map(cat, JobRequestDTO.class)).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    @Override
    public Boolean insert(String title, String position, String date, String description, String email, String username) {
        JobRequest jobRequest = new JobRequest();
        jobRequest.setDate(LocalDate.parse(date));
        jobRequest.setDescription(description);
        jobRequest.setEmail(email);
        jobRequest.setTitle(title);
        jobRequest.setUsername(username);
        jobRequest.setPosition(position);
        jobRequestDAO.save(jobRequest);
        return true;
    }

    @Override
    public Boolean delete(JobRequestDTO jobRequestDTO) {
        jobRequestDAO.delete(modelMapper.map(jobRequestDTO, JobRequest.class));
        return true;
    }

    @Override
    public JobRequestDTO getByUsername(String username) {
        JobRequest j = null;
        if(jobRequestDAO.getByUsername(username).isPresent())
        {
            j = jobRequestDAO.getByUsername(username).get();
        }
        return modelMapper.map(j, JobRequestDTO.class);
    }
}
