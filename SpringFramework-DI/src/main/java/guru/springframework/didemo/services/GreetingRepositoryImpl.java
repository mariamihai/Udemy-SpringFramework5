package guru.springframework.didemo.services;

import org.springframework.stereotype.Component;

@Component
public class GreetingRepositoryImpl implements GreetingRepository {

    @Override
    public String getEnglishGreeting() {
        return "Hello, Primary Greeting Service";
    }

    @Override
    public String getGermanGreeting() {
        return "Guten Tag";
    }

    @Override
    public String getSpanishGreeting() {
        return "Servicio de Saludo Primario";
    }
}
