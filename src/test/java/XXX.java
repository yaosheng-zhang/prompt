import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author Xzzz
 * @data 2023/07/03
 */
public class XXX {
    @Test
    void test_prompt(){
        String content= "\ttemplate <> struct wchar_selector<2>\n" +
                "\t{\n" +
                "\t\ttypedef uint16_t type;\n" +
                "\t\ttypedef utf16_counter counter;\n" +
                "\t\ttypedef utf16_writer writer;\n" +
                "\t\ttypedef utf16_decoder<opt_false> decoder;\n" +
                "\t};";
        Integer lineNum=1;
        String msg="Rule Required 2.2: There shall be no dead code.";
        String acode ="\t\t\t*this = rhs + 0;";
        String[] lists={
                "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",
                "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",
                "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"
        };
        String prompt = IssueService.getPrompt(content, msg, lineNum, acode);
        System.out.println(prompt);
        List<String> list = Arrays.asList(lists);
        Generator generator = new Generator();
        String codeFromModle = generator.getCodeFromModle(prompt, list);
        System.out.println(codeFromModle);
    }

}
