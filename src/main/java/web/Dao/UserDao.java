package web.Dao;
import org.springframework.data.jpa.repository.JpaRepository;
import web.model.User;

public interface UserDao extends JpaRepository<User, Integer> {
}
