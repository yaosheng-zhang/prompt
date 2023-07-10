import com.plexpt.chatgpt.ChatGPT;
import com.plexpt.chatgpt.entity.chat.ChatCompletion;
import com.plexpt.chatgpt.entity.chat.ChatCompletionResponse;
import com.plexpt.chatgpt.entity.chat.Message;
import com.plexpt.chatgpt.util.Proxys;

import java.net.Proxy;
import java.util.Arrays;
import java.util.List;


public class Generator {


    private static final String API_HOST="https://api.openai.com/";


    public String  getCodeFromModle(String code, List<String> apiLists){
        //国内需要代理 国外不需要
//        final String SYSTEM="You as a developer are asked to refactor a specified number of lines in the code, " +
//                "and only the refactored code is allowed to appear in the returned results; non-code parts must appear " +
//                "as JAVA comments //";
        final String SYSTEM="You are a professional c/c++ code reviewer specializing in refactoring odorous code in c/c++ code";
        Proxy proxy = Proxys.http("127.0.0.1", 1080);

        //获取api


        ChatGPT chatGPT = ChatGPT.builder()
                .apiKeyList(apiLists)
                .proxy(proxy)
                .timeout(900)
                .apiHost(API_HOST) //反向代理地址
                .build()
                .init();

        Message system = getSystem(SYSTEM);
        Message message = getMessage(code);

        ChatCompletion chatCompletion = ChatCompletion.builder()
                .model(ChatCompletion.Model.GPT_3_5_TURBO.getName())
                .messages(Arrays.asList(system, message))
                .temperature(2)
                .presencePenalty(0)
                .frequencyPenalty(0)
                .build();

        ChatCompletionResponse response = chatGPT.chatCompletion(chatCompletion);
        Message res = response.getChoices().get(0).getMessage();
        return res.getContent();
    }



    public String  getConfidenceFromModle(String code, List<String> apiLists){
        final String SYSTEM="你将获得actionable置信度查询。\n" +
                "每个查询都将用json格式包含code和msg两个键。\n" +
                "你将收到一份代码片段和一个static analysis tool产生的警告，你需要判断这个警告是否为actionable并给出confidence。\n" +
                "以JSON格式提供你的输出，包含以下键：confidence和reason。";

        //国内需要代理 国外不需要

        Proxy proxy = Proxys.http("127.0.0.1", 1080);



        ChatGPT chatGPT = ChatGPT.builder()
                .apiKeyList(apiLists)
                .proxy(proxy)
                .timeout(900)
                .apiHost(API_HOST) //反向代理地址
                .build()
                .init();

        Message system = getSystem(SYSTEM);
        Message message = getMessage(code);

        ChatCompletion chatCompletion = ChatCompletion.builder()
                .model(ChatCompletion.Model.GPT_3_5_TURBO.getName())
                .messages(Arrays.asList(system, message))
                .temperature(0.5)
                .presencePenalty(0)
                .frequencyPenalty(0)
                .build();

        ChatCompletionResponse response = chatGPT.chatCompletion(chatCompletion);
        Message res = response.getChoices().get(0).getMessage();
        return res.getContent();
    }



    private Message getMessage(String code) {
        return Message.of(code);
    }
    private Message getSystem(String system) {
        return Message.ofSystem(system);
    }





}
