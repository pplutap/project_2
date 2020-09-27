package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

    @Entity
    @Table(name = "Groups")
    public class Group {
        private Long id;
        private String nameGroup;
        private String description;

        public Group() {
        }

        public Group(String nameGroup, String description) {
            this.nameGroup = nameGroup;
            this.description = description;
        }

        @Id
        @GeneratedValue
        @NotNull
        @Column(name = "GROUP_ID", unique = true)
        public Long getId() {
            return id;
        }

        @NotNull
        @Column(name = "NAMEGROUP")
        public String getNameGroup() {
            return nameGroup;
        }

        @NotNull
        @Column(name = "DESCRIPTION")
        public String getDescription() {
            return description;
        }

        private void setId(Long id) {
            this.id = id;
        }

        private void setNameGroup(String nameGroup) {
            this.nameGroup = nameGroup;
        }

        private void setDescription(String description) {
            this.description = description;
        }
    }

