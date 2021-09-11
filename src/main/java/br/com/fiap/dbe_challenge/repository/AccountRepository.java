package br.com.fiap.dbe_challenge.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.dbe_challenge.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

	Page<Account> findByNomeLike(String string, Pageable pageable);

}
