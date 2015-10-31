package ifpr.pessoa.usuario.colaborador;

import ifpr.pessoa.usuario.Usuario;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tbColaborador")
public class Colaborador extends Usuario{

}
