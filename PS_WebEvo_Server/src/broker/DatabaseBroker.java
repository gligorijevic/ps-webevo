/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package broker;

import java.util.HashMap;
import java.util.List;
import model.GeneralDomainObject;
import model.users.User;

/**
 *
 * @author Djordje Gligorijevic
 */
public interface DatabaseBroker {

    public List<GeneralDomainObject> returnAll(GeneralDomainObject gdo);

    public List<GeneralDomainObject> returnGDOforCondition(GeneralDomainObject odo, HashMap<String, Object> mapFieldValue) throws Exception;

    public void createNew(GeneralDomainObject odo) throws Exception;

    public void saveGDO(GeneralDomainObject odo) throws Exception;

    public boolean deleteGDO(GeneralDomainObject d);

    public boolean updateGDO(GeneralDomainObject d);

    public boolean beginTransaction();

    public boolean closeTransaction();

    public boolean commitTransaction();

    public boolean rollbackTransaction();

    public int getMaxId(GeneralDomainObject gdo);

    public User loginUser(User loginUser);

    public void registerNewUser(User regUser) throws Exception;
}
