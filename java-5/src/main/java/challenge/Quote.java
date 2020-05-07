package challenge;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "scripts")
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotNull
    @Size(max = 100)
    private String actor;
    
    @Column
    @NotNull
    @Size(max = 100)
    private String detail;
    
    public String getQuote() {
    	return this.detail;
    }

    public void setQuote(String quote) {
    	this.detail = quote;
    }
    
    public void setId(Integer id) {
    	this.id = id;
    }
    
    public void setActor(String actor) {
    	this.actor = actor;
    }

}
