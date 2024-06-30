package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Aluno;
import factories.ConnectionFactory;

public class AlunoRepository {

	public void create(Aluno aluno) throws Exception {
		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection
				.prepareStatement("INSERT INTO aluno(idAluno, nome, matricula, cpf) VALUES(?, ?, ?, ?)");

		statement.setInt(1, aluno.getIdAluno());
		statement.setObject(2, aluno.getNome());
		statement.setObject(3, aluno.getMatricula());
		statement.setObject(4, aluno.getCpf());

		statement.execute();
		connection.close();
	}

	public void update(Aluno aluno) throws Exception {
		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection
				.prepareStatement("UPDATE aluno SET nome=?, matricula=?, cpf=? WHERE idAluno=?");

		statement.setString(1, aluno.getNome());
		statement.setString(2, aluno.getMatricula());
		statement.setString(3, aluno.getCpf());
		statement.setInt(4, aluno.getIdAluno());

		statement.execute();
		connection.close();
	}

	public void delete(Aluno aluno) throws Exception {
		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement("DELETE FROM aluno WHERE idAluno=?");

		statement.setInt(1, aluno.getIdAluno());

		statement.execute();
		connection.close();
	}

	public List<Aluno> findAll() throws Exception {
		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement("SELECT idAluno, nome, matricula, cpf FROM Aluno ORDER BY nome");

		ResultSet resultSet = statement.executeQuery();

		List<Aluno> lista = new ArrayList<Aluno>();

		while (resultSet.next()) {
			Aluno aluno = new Aluno();

			aluno.setIdAluno(Integer.parseInt(resultSet.getString("idAluno")));
			aluno.setNome(resultSet.getString("nome"));
			aluno.setMatricula(resultSet.getString("matricula"));
			aluno.setCpf(resultSet.getString("cpf"));

			lista.add(aluno);
		}
		connection.close();
		return lista;
	}

	public Aluno findbyId(Integer idAluno) throws Exception {
		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement("SELECT idAluno, nome, matricula, cpf FROM aluno WHERE idAluno=?");

		statement.setObject(1, idAluno);
		ResultSet resultSet = statement.executeQuery();

		Aluno aluno = null;

		if (resultSet.next()) {

			aluno = new Aluno();

			aluno.setIdAluno(Integer.parseInt(resultSet.getString("idAluno")));
			aluno.setNome(resultSet.getString("nome"));
			aluno.setMatricula(resultSet.getString("matricula"));
			aluno.setCpf(resultSet.getString("cpf"));
		}
		connection.close();
		return aluno;
	}
}
