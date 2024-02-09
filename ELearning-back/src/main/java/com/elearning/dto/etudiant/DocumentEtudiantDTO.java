package com.elearning.dto.etudiant;

import com.elearning.dto.MyDTO;

public class DocumentEtudiantDTO extends MyDTO {
    private Long id;
    private String documentName;
    private String documentFile;

    private String recap;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getDocumentFile() {
        return documentFile;
    }

    public void setDocumentFile(String documentFile) {
        this.documentFile = documentFile;
    }

    public String getRecap() {
        return recap;
    }

    public void setRecap(String recap) {
        this.recap = recap;
    }


}
