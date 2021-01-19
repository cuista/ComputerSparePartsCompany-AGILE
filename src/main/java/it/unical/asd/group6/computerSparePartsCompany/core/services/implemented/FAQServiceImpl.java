package it.unical.asd.group6.computerSparePartsCompany.core.services.implemented;
import it.unical.asd.group6.computerSparePartsCompany.core.exception.faq.FAQByDescriptionNotFoundException;
import it.unical.asd.group6.computerSparePartsCompany.core.exception.faq.FAQByTitleNotFoundException;
import it.unical.asd.group6.computerSparePartsCompany.core.services.FAQService;
import it.unical.asd.group6.computerSparePartsCompany.data.dao.FAQDao;
import it.unical.asd.group6.computerSparePartsCompany.data.dto.FAQDTO;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.FAQ;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FAQServiceImpl implements FAQService {

    @Autowired
    FAQDao faqDao;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public Boolean insert(String title, String text) {
        FAQ faq = new FAQ();
        faq.setTitle(title);
        faq.setDescription(text);
        faqDao.save(faq);
        return true;
    }

    @Override
    public List<FAQDTO>getAll() {
        Optional<List<FAQ>> faqs = faqDao.getAll();
        if(faqs.isPresent())
        {
            List<FAQ>fs = faqs.get();
            return fs.stream().map(cat -> modelMapper.map(cat, FAQDTO.class)).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    @Override
    public FAQ getByTitle(String title) {
        FAQ faq = faqDao.getByTitle(title).orElseThrow(() -> new FAQByTitleNotFoundException(title));
        return faq;
    }

    @Override
    public FAQDTO getByDescription(String description) {
        FAQ faq = faqDao.getByDescription(description).orElseThrow(() -> new FAQByDescriptionNotFoundException(description));
        return modelMapper.map(faq, FAQDTO.class);
    }

    @Override
    public Boolean remove(FAQ f) {
        faqDao.delete(f);
        return true;
    }

    @Override
    public Boolean delete(FAQ f) {
        faqDao.delete(f);
        return true;
    }

    @Override
    public Boolean deleteAll() {
        List<FAQDTO>faqs = getAll();
        for(int i = 0; i < faqs.size(); i++)
        {
            FAQ faq = modelMapper.map(faqs.get(i),FAQ.class);
            delete(faq);
        }
        return true;
    }
}
