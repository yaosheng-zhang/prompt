
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;





public class IssueService {




    private static List<String> toList(String res) {
        String[] split = res.split("\n");
        List<String> resList = Arrays.asList(split);
        return resList;
    }
//    public Error getIssue(Issue issue) {
//        String adr = dealPath(issue.getPath());
//
//    }

    /**
     * 寻址
     * @param path
     * @return
     */

    /**
     * 异味重构
     *


    /**
     * prompt生成
     *
     * @param content
     * @param msg
     * @param line
     * @param acode
     * @return
     */

        public static String getPrompt(String content, String msg, Integer line, String acode){



//            String prompt = "Your task is to refactor the specified lines of code in the following code according to " +
//                    "MISRA requirements and specifications\nThe code is as follows：\n"+content+"\n"
//                    +"\nThe Misra rules that were violated were:"+msg+
////                    "\nyou can only refactor the "+line+" line of code: "+acode+ "!"+
////                    "\nInsert the repaired code into the originally provided code, replacing the specified lines. " +
////                    "Get the final fix." +
////                    "Do not allow any other code to be added or modified" +
//                    "\nThe returned result requires only the refactored code and retains the original code formatting " +
//                    "characters (e.g. spaces) and symbols"+
//                    "the non-code part must appear as a JAVA comment //"
//                    ;You are a professional c/c++ code reviewer specializing in refactoring smell code in c/c++ code,
            String prompt = "please  refactor the code specified in  code block according to Misra's specification for the refactoring,only \"code violations of Misra\" can be refactored, here is an refactor example" +
                    "\n# Code blocks with odours\n" +
                    "    typedef common_utils::FileSystem FileSystem;\n" +
                    "    typedef common_utils::Utils Utils;\n" +
                    "    typedef msr::airlib::VectorMath VectorMath;\n" +
                    "    typedef common_utils::RandomGeneratorF RandomGeneratorF;\n" +
                    "    typedef msr::airlib::Vector3r Vector3r;\n" +
                    "    typedef msr::airlib::Quaternionr Quaternionr;\n" +
                    "    typedef msr::airlib::Pose Pose;\n" +

                    "# Misra Rule\n" +
                    "Rule Advisory 2.3: A project should not contain unused type declarations.\n" +

                    "#  code violations of Misra\n" +
                    "    typedef common_utils::RandomGeneratorF RandomGeneratorF;\n" +

                    "# refactored code\n" +
                    "    typedef common_utils::FileSystem FileSystem;\n" +
                    "    typedef common_utils::Utils Utils;\n" +
                    "    typedef msr::airlib::VectorMath VectorMath;\n" +
                    "    //typedef common_utils::RandomGeneratorF RandomGeneratorF;\n" +
                    "    typedef msr::airlib::Vector3r Vector3r;\n" +
                    "    typedef msr::airlib::Quaternionr Quaternionr;\n" +
                    "    typedef msr::airlib::Pose Pose;\n" +
//                    Refactor a similar refactoring of the code specified in the following code block based on the above example.
                    "### \n" +
                    "# Code blocks with odours\n"
                    +content+
                    "\n# Misra Rule\n" +
                     msg +
                    "\n# code violations of Misra\n"
                    +acode+

                    "\n# refactored code:\n"
                    ;

            return prompt;
        }
        /*
        根据行号获取到代码上下文
         */






}

