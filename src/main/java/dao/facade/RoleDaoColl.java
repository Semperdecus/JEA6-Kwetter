/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.facade;

import dao.IRoleDao;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import models.Account;
import models.Role;

/**
 *
 * @author teren
 */
public class RoleDaoColl implements IRoleDao {

    CopyOnWriteArrayList<Role> roles = new CopyOnWriteArrayList<>();

    public void addRole(Role role) {
        roles.add(role);
    }

    public void removeRole(Role role) {
        roles.remove(role);
    }

    public ArrayList<Role> getAllRoles() {
        return new ArrayList<>(roles);
    }

    public ArrayList<Account> getAllAccountsWithRole(String roleName) {
        for (Role role : roles) {
            if (role.getName().contentEquals(roleName)) {
                return new ArrayList<>(role.getAccounts());
            }
        }
        return null;
    }

    public Role findByName(String name) {
        for (Role role : roles) {
            if (role.getName().contentEquals(name)) {
                return role;
            }
        }
        return null;
    }
    
    @Override
    public Role getRoleByName(String Rolename) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Role> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Role create(Role object) {
        roles.add(object);
        return object;
    }

    @Override
    public Role update(Role t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Role object) {
        roles.remove(object);
    }

    @Override
    public void deleteById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Role findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Role findObject(Role object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
