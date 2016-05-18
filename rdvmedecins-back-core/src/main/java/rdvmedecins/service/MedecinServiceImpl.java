package rdvmedecins.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rdvmedecins.domain.Client;
import rdvmedecins.domain.Medecin;
import rdvmedecins.repository.MedecinRepository;

@Service
@Transactional
public class MedecinServiceImpl implements MedecinService {

	/*
	 * DEPENDENCY INJECTION
	 * =========================================================================
	 */

	@Autowired
	private MedecinRepository medecinRepository;

	/*
	 * SERVICES METHODS
	 * =========================================================================
	 */

	@Override
	public Medecin createMedecin(Medecin medecin) {
		return medecinRepository.save(medecin);
	}

	@Override
	public Medecin updateMedecin(Medecin medecin) {
		return medecinRepository.save(medecin);
	}

	@Override
	public void deleteMedecin(Long id) {
		medecinRepository.delete (id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Medecin> findAllMedecins() {
		List<Medecin> medecins = medecinRepository.findAll();
		return medecins;
	}
	
	@Override
	@Transactional(readOnly = true)
	public Medecin findOneMedecin(Long id) {
		return medecinRepository.findOne(id);
	}

	@Override
	public List<Medecin> searchMedecins() {
		// TODO implement elastic search repository
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public Long countAllMedecins() {		
		return medecinRepository.count();
	}

}