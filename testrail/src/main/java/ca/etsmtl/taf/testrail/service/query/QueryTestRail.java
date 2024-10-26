package ca.etsmtl.taf.testrail.service.query;

import ca.etsmtl.taf.testrail.model.entity.TestRailData;
import ca.etsmtl.taf.testrail.model.entity.TestRailProject;

import java.util.List;

interface QueryTestRail {
    /*
    * Interface that contains common requests about TestRail data
    * Those methods are implemented in the classes that will query TestRail
    * */

    TestRailData getById(int id);

    TestRailData getByName(String name);

    List<TestRailData> getAll();

    TestRailData addNew(String name);
}