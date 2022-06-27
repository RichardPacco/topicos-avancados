package senai.topicos.util;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
@RequiredArgsConstructor
public class MessageProvider {

    private final MessageSource messageSource;

    public String getMessage(String code, String... inputs) {
        return messageSource.getMessage(code, inputs, Locale.getDefault());
    }
}
