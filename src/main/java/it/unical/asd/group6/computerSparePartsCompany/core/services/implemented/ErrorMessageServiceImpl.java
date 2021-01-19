package it.unical.asd.group6.computerSparePartsCompany.core.services.implemented;

import it.unical.asd.group6.computerSparePartsCompany.core.services.ErrorMessageService;
import it.unical.asd.group6.computerSparePartsCompany.data.dao.ErrorMessageDAO;
import it.unical.asd.group6.computerSparePartsCompany.data.dao.JobRequestDAO;
import it.unical.asd.group6.computerSparePartsCompany.data.dto.ErrorMessageDTO;
import it.unical.asd.group6.computerSparePartsCompany.data.dto.FAQDTO;
import it.unical.asd.group6.computerSparePartsCompany.data.dto.JobRequestDTO;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.ErrorMessage;
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
public class ErrorMessageServiceImpl implements ErrorMessageService {

    @Autowired
    ErrorMessageDAO errorMessageDao;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public Boolean insert(String title, String description, String email, String username) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setDescription(description);
        errorMessage.setEmail(email);
        errorMessage.setTitle(title);
        errorMessage.setUsername(username);
        errorMessageDao.save(errorMessage);
        return true;
    }

    @Override
    public Boolean remove(String username) {
        ErrorMessageDTO errorMessageDTO = getByUsername(username);
        errorMessageDao.delete(modelMapper.map(errorMessageDTO, ErrorMessage.class));
        return true;
    }

    @Override
    public List<ErrorMessageDTO> getAll() {
        Optional<List<ErrorMessage>> errors = errorMessageDao.getAll();
        if(errors.isPresent())
        {
            List<ErrorMessage>fs = errors.get();
            return fs.stream().map(cat -> modelMapper.map(cat, ErrorMessageDTO.class)).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    @Override
    public ErrorMessageDTO getByUsername(String username) {
        ErrorMessage error = errorMessageDao.getAllByUsername(username).get();
        return modelMapper.map(error, ErrorMessageDTO.class);
    }
}
