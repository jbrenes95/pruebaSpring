package com.example.demo;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

interface MovieRepository extends JpaRepository<Movie, Long>, JpaSpecificationExecutor<Movie> {

    static Specification<Movie> isBrian() {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("title"), "la vida de brian");
    }

    static Specification<String> searchDescription(String word) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("description"), "%" + word + "%");
    }

}




