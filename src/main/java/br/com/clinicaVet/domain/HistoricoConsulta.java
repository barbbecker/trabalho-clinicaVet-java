package br.com.clinicaVet.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "historico_consulta")
public class HistoricoConsulta extends BaseDomain {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "historico_consultaid")
	private Integer id;

	@NotNull
	@Column(name = "data_atendimento")
	private LocalDate dataAtendimento;

	@NotNull(message = "O diagnostico nao pode ser nulo")
	@NotEmpty(message = "O diagnostico nao pode ser vazio")
	private String diagnostico;

	@ManyToOne
	@JoinColumn(name = "veterinarioid")
	private Veterinario veterinario;

	public HistoricoConsulta(LocalDate dataAtendimento, String diagnostico, Veterinario veterinario) {
		this.dataAtendimento = dataAtendimento;
		this.diagnostico = diagnostico;
		this.veterinario = veterinario;
		validarDomain();
	}

	public HistoricoConsulta(Integer id, LocalDate dataAtendimento, String diagnostico, Veterinario veterinario) {
		this(dataAtendimento, diagnostico, veterinario);
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public LocalDate getDataAtendimento() {
		return dataAtendimento;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public Veterinario getVeterinario() {
		return veterinario;
	}

}