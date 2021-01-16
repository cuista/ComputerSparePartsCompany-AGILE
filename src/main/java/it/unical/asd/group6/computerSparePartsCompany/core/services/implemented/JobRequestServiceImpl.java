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
    public Boolean insert(JobRequest jobRequest) {
        jobRequestDAO.save(jobRequest);
        return true;
    }

    @Override
    public Boolean delete(JobRequest jobRequest) {
        jobRequestDAO.delete(jobRequest);
        return true;
    }

    @Override
    public JobRequestDTO getByUsername(String username) {
        JobRequest j = jobRequestDAO.getByUsername(username).get();
        return modelMapper.map(j, JobRequestDTO.class);
    }
}
