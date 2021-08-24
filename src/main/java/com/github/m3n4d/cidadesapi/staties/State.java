package com.github.m3n4d.cidadesapi.staties;

import com.github.m3n4d.cidadesapi.countries.Country;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.List;

    @Entity(name = "State")
    @Table(name = "estado")

    //Essa dependencia ensina o Hibernate a trabalhar com o tipo JSON da BD
   @TypeDefs({
            @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
    })

    public class State {

        @Id
        private Long id;

        @Column(name = "nome")
        private String name;

        private String uf;

        private Integer ibge;

  // Mostra as cidades com o ID do país
  /*@Column(name = "pais")
  private Integer countryId;*/

        // @ManyToOne - Mostra as cidades com o nome do País
        @ManyToOne
        @JoinColumn(name = "pais", referencedColumnName = "id")
        private Country country;

        @Type(type = "jsonb")
        @Basic(fetch = FetchType.LAZY)
        @Column(name = "ddd", columnDefinition = "jsonb")
        private List<Integer> ddd;

        public State() {
        }

        public Long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getUf() {
            return uf;
        }

        public Integer getIbge() {
            return ibge;
        }

        public List<Integer> getDdd() {
            return ddd;
        }

       public Country getCountry() {
            //Country country;
            return country;
        }

 /* public Integer getCountryId() {
      return countryId;
  }*/
    }

