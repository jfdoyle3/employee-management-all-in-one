//package com.openshift.employeemanagement.utils;
//
//import com.openshift.employeemanagement.entities.Employee;
//import org.apache.commons.csv.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.*;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Date;
//import java.util.List;
//
//public class CSVHelper {
//    private static String TYPE = "text/csv";
//    private static String pattern = "MM/dd/yyyy HH:mm:ss";
//    private static DateFormat df = new SimpleDateFormat(pattern);
// //   private static DateFormat df = new SimpleDateFormat();
//
//    // name role department location supervisor salary dateHired shifts
//
//    static String[] HEADERs = { "Name", "Role", "Department", "Location","Supervisor","Salary","DateHired","Shift" };
//
//    public static boolean hasCSVFormat(MultipartFile file) {
//        if (TYPE.equals(file.getContentType())
//                || file.getContentType().equals("application/vnd.ms-excel")) {
//            return true;
//        }
//
//        return false;
//    }
//
//    public static List<Employee> csvToTutorials(InputStream is) {
//        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
//             CSVParser csvParser = new CSVParser(fileReader,
//                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
//
//            List<Employee> employeeList = new ArrayList<>();
//
//            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
//
//            for (CSVRecord csvRecord : csvRecords) {
//                // name role department location supervisor salary dateHired shifts
//                Employee employee = new Employee(
//                        csvRecord.get("Name"),
//                        csvRecord.get("Role"),
//                        csvRecord.get("Department"),
//                        csvRecord.get("Location"),
//                        csvRecord.get("Supervisor"),
//                        Double.parseDouble(csvRecord.get("Salary")),
//                        df.format(csvRecord.get("DateHired")),
//                        csvRecord.get("Shift")
//
//                );
//
//                employeeList.add(employee);
//            }
//
//            return employeeList;
//        } catch (IOException e) {
//            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
//        }
//    }
//
//    public static ByteArrayInputStream tutorialsToCSV(List<Employee> employeeList) {
//        final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);
//
//        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
//             CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
//            for (Employee employee : employeeList) {
//                List<String> data = Arrays.asList(
//                        String.valueOf(employee.getId()),
//                        employee.getTitle(),
//                        employee.getDescription(),
//                        String.valueOf(employee.isPublished())
//                );
//
//                csvPrinter.printRecord(data);
//            }
//
//            csvPrinter.flush();
//            return new ByteArrayInputStream(out.toByteArray());
//        } catch (IOException e) {
//            throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
//        }
//    }
//}
//
//
//
//    // Create an instance of SimpleDateFormat used for formatting
//// the string representation of date according to the chosen pattern
//
//
//    // Get the today date using Calendar object.
//    Date today = Calendar.getInstance().getTime();
//    // Using DateFormat format method we can create a string
//// representation of a date with the defined format.
//    String todayAsString =
//
//// Print the result!
//System.out.println("Today is: " + todayAsString);