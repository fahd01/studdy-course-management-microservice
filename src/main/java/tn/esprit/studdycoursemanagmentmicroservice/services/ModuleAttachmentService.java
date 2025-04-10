package tn.esprit.studdycoursemanagmentmicroservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.studdycoursemanagmentmicroservice.entities.ModuleAttachment;
import tn.esprit.studdycoursemanagmentmicroservice.repositories.ModuleAttachmentRepository;

import java.io.IOException;

@RequiredArgsConstructor
@Service
public class ModuleAttachmentService {

  private final ModuleAttachmentRepository moduleAttachmentRepository;

  public void store(ModuleAttachment attachment) throws IOException {
    moduleAttachmentRepository.save(attachment);
  }

}