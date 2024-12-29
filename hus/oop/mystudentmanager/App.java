package hus.oop.mystudentmanager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class App {
    private static final String COMMA_DELIMITER = ",";
    private static final String OUTPUT_FILE = "NguyenMinhTuan_20000594_StudentManager.txt";
    private static final StudentManager studentManager = StudentManager.getInstance();

    public static void readListData(String filePath) {
        BufferedReader dataReader = null;
        try {
            String line;
            dataReader = new BufferedReader(new FileReader(filePath));

            // Read file line by line?
            while ((line = dataReader.readLine()) != null) {
                List<String> dataList = parseDataLineToList(line);
                if (dataList.size() != 7) {
                    continue;
                }

                if (dataList.get(0).equals("id")) {
                    continue;
                }

                /*
                TODO

                - Đọc được dữ liệu, tạo ra các đối tượng sinh viên ở đây, và cho vào đối tượng được tạo ra từ
                lớp StudentManager để quản lý.
                - Đối tượng tạo ra từ lớp StudentManager là duy nhất trong chương trình, do dùng Singleton Pattern,
                và được tạo ra bằng cách gọi hàm StudentManager.getInstance().
                */
               try {
                   String id = dataList.get(0);
                   String lastname = dataList.get(1);
                   String firstname = dataList.get(2);
                   int yearOfBirth = Integer.parseInt(dataList.get(3));
                   double mathGrade = Double.parseDouble(dataList.get(4));
                   double physicGrade = Double.parseDouble(dataList.get(5));
                   double chemistryGrade = Double.parseDouble(dataList.get(6));

                   Student student = new Student.StudentBuilder(id)
                           .withLastname(lastname)
                           .withFirstname(firstname)
                           .withYearOfBirth(yearOfBirth)
                           .withMathsGrade(mathGrade)
                           .withPhysicsGrade(physicGrade)
                           .withChemistryGrade(chemistryGrade).build();

                   studentManager.append(student);
               } catch (NumberFormatException e) {
                   e.printStackTrace();
               }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dataReader != null)
                    dataReader.close();
            } catch (IOException crunchifyException) {
                crunchifyException.printStackTrace();
            }
        }
    }

    public static List<String> parseDataLineToList(String dataLine) {
        List<String> result = new ArrayList<>();
        if (dataLine != null) {
            String[] splitData = dataLine.split(COMMA_DELIMITER);
            for (int i = 0; i < splitData.length; i++) {
                result.add(splitData[i]);
            }
        }
        return result;
    }

    public static String[] parseDataLineToArray(String dataLine) {
        if (dataLine == null) {
            return null;
        }

        return dataLine.split(COMMA_DELIMITER);
    }

    public static void main(String[] args) {
        init();
        try (PrintWriter writer = new PrintWriter(new FileWriter(OUTPUT_FILE))) {
            testOriginalData(writer);
            writer.println();
            testFilterStudentsByAverageGrade(writer);
            writer.println();
            testFilterStudentsByMathGrade(writer);


        } catch (IOException e) {
            e.printStackTrace();
        }

        /* Yêu cầu:
        - Hoàn thiện code chương trình theo mẫu và theo yêu cầu đã cho.
        - Viết code để test cho tất cả các hàm test.

        - Thực hiện chạy từng hàm test, lưu kết quả chạy chương trình và file text được đặt tên
          là <TenSinhVien_MaSinhVien_StudentManager>.txt (Ví dụ, NguyenVanA_123456_StudentManager.txt).
        - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
          <TenSinhVien_MaSinhVien_StudentManager>.zip (Ví dụ, NguyenVanA_123456_StudentManager.zip),
          nộp lên classroom.
         */
    }

    public static void init() {
        String filePath = "C:\\Users\\Admin\\Desktop\\2324OOP_DinalExam_KHMTvsTT\\data\\students.csv";
        readListData(filePath);
    }

    public static void testOriginalData(PrintWriter writer) {
        /* TODO */
        for (int i = 0; i < studentManager.getStudentList().size(); i++) {
            writer.println(studentManager.studentAt(i));
        }
    }

    public static void testFilterStudentsByAverageGrade(PrintWriter writer) {
        /* TODO */
        writer.println("List students have ave > 15: ");
        //MyList list = studentManager.filterStudentsByAverageGrade();
        for (int i = 0; i < studentManager.filterStudentsByAverageGrade().size(); i++) {
            writer.println(studentManager.filterStudentsByAverageGrade().get(i));
        }
    }

    public static void testFilterStudentsByMathGrade(PrintWriter writer) {
        /* TODO */
        writer.println("List students have math grade > 5: ");
        //MyList list = studentManager.filterStudentsByMathGrade();
        for (int i = 0; i < studentManager.filterStudentsByMathGrade().size(); i++) {
            writer.println(studentManager.filterStudentsByMathGrade().get(i));
        }
    }
}
