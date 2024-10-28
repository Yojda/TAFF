package ca.etsmtl.taf.testrail.service.export;

public class ExportGatling implements ExportServiceInterface {
    @Override
    public void exportData() {
        System.out.println("Exporting Gatling data");
    }
}
