package com.elearning.dto.etudiant;

import com.elearning.dto.MyDTO;

public class VideoEtudiantDTO extends MyDTO {
    private Long id;
    private String vedioName;
    private String vedioFile;

    private String recap;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVedioName() {
        return vedioName;
    }

    public void setVedioName(String vedioName) {
        this.vedioName = vedioName;
    }

    public String getVedioFile() {
        return vedioFile;
    }

    public void setVedioFile(String vedioFile) {
        this.vedioFile = vedioFile;
    }

    public String getRecap() {
        return recap;
    }

    public void setRecap(String recap) {
        this.recap = recap;
    }
}
