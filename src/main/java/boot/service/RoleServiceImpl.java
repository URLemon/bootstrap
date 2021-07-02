package boot.service;

import boot.model.Role;
import boot.repository.RoleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class RoleServiceImpl implements RoleService{

    private RoleRepository dao;

    public RoleServiceImpl(RoleRepository dao){
        this.dao = dao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Role> findAllRoles() {
        return dao.findAll();
    }
}

