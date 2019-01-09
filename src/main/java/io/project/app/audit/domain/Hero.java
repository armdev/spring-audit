package io.project.app.audit.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author armena
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hero implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String firstname;

    private String middlename;

   


}
