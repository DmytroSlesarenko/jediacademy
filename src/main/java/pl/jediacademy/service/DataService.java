package pl.jediacademy.service;

import org.springframework.stereotype.Service;
import pl.jediacademy.model.*;
import pl.jediacademy.repository.*;

import java.util.Arrays;

@Service
public class DataService {


    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private TierRepository tierRepository;
    private SubjectRepository subjectRepository;
    private QuestionRepository questionRepository;
    private QuizRepository quizRepository;
    private AchievementRepository achievementRepository;


    public DataService(UserRepository userRepository, RoleRepository roleRepository, TierRepository tierRepository, SubjectRepository subjectRepository, QuestionRepository questionRepository, QuizRepository quizRepository, AchievementRepository achievementRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.tierRepository = tierRepository;
        this.subjectRepository = subjectRepository;
        this.questionRepository = questionRepository;
        this.quizRepository = quizRepository;
        this.achievementRepository = achievementRepository;
    }

    public void loadData(){
        //role: user
        Role role1 = new Role();
        role1.setName("USER");
        roleRepository.save(role1);
        //role: user
        Role role2 = new Role();
        role2.setName("ADMIN");
        roleRepository.save(role2);
        //Achivment
        Achievement achievement1 = new Achievement();
        achievement1.setName("Moc silną w tobie czuję");
        achievement1.setImg("https://cdn.akamai.steamstatic.com/steamcommunity/public/images/apps/438640/b18058fbd486fa44ca3a6a5bc46b12daa2967fd8.jpg");
        achievementRepository.save(achievement1);
        Achievement achievement2 = new Achievement();
        achievement2.setName("Chewie, jesteśmy w domu");
        achievement2.setImg("https://cdn.akamai.steamstatic.com/steamcommunity/public/images/apps/438640/4f58771bd5f6c540e7ca281d5a945022dfb26841.jpg");
        achievementRepository.save(achievement2);
        //Tier
        tierRepository.saveAll(Arrays.asList(new Tier("JEDI",100L), new Tier("RANGER", 75L), new Tier("PADAWAN", 50L)));
        //Subject
        subjectRepository.saveAll(Arrays.asList(new Subject("Geography"), new Subject("English")));
        //Quiz
        quizRepository.save(new Quiz("Stolice Państw!", subjectRepository.findByName("Geography")));
        quizRepository.save(new Quiz("Dni tygodnia!", subjectRepository.findByName("English")));
        quizRepository.save(new Quiz("Miesiące!", subjectRepository.findByName("English")));
        //Questions
        Quiz quiz1 = quizRepository.findById(1L).get();
        questionRepository.saveAll(Arrays.asList(
                new Question("Albania", "Tirana", quiz1),
                new Question("Andora", "Andorra La Vella", quiz1),
                new Question("Austria", "Wiedeń", quiz1),
                new Question("Belgia", "Bruksela", quiz1),
                new Question("Białoruś", "Mińsk", quiz1),
                new Question("Bośnia i Hercegowina", "Sarajewo", quiz1),
                new Question("Bułgaria", "Sofia", quiz1),
                new Question("Chorwacja", "Zagrzeb", quiz1),
                new Question("Czarnogóra", "Podgorica", quiz1),
                new Question("Czechy", "Praga", quiz1),
                new Question("Dania", "Kopenhaga", quiz1),
                new Question("Estonia", "Tallinn", quiz1),
                new Question("Francja", "Paryż", quiz1),
                new Question("Grecja", "Ateny", quiz1),
                new Question("Hiszpania", "Madryt", quiz1),
                new Question("Holandia", "Amsterdam", quiz1),
                new Question("Irlandia", "Dublin", quiz1),
                new Question("Islandia", "Reykjavík", quiz1),
                new Question("Kosowo", "Prisztina", quiz1),
                new Question("Liechtenstein", "Vaduz", quiz1),
                new Question("Litwa", "Wilno" , quiz1),
                new Question("Luksemburg", "Luksemburg" , quiz1),
                new Question("Łotwa", "Ryga" , quiz1),
                new Question("Macedonia", "Skopje" , quiz1),
                new Question("Malta", "Valletta" , quiz1),
                new Question("Mołdawia", "Kiszyniów" , quiz1),
                new Question("Monako", "Monako" , quiz1),
                new Question("Niemcy", "Berlin" , quiz1),
                new Question("Norwegia", "Oslo" , quiz1),
                new Question("Polska", "Warszawa" , quiz1),
                new Question("Portugalia", "Lizbona" , quiz1),
                new Question("Rosja", "Moskwa" , quiz1),
                new Question("Rumunia", "Bukareszt" , quiz1),
                new Question("San Marino", "San Marino" , quiz1),
                new Question("Serbia", "Belgrad" , quiz1),
                new Question("Słowacja", "Bratysława" , quiz1),
                new Question("Słowenia", "Lublana" , quiz1),
                new Question("Szwajcaria", "Berno" , quiz1),
                new Question("Szwecja", "Sztokholm" , quiz1),
                new Question("Turcja", "Ankara" , quiz1),
                new Question("Ukraina", "Kijów" , quiz1),
                new Question("Watykan", "Watykan" , quiz1),
                new Question("Węgry", "Budapeszt" , quiz1),
                new Question("Wielka Brytania", "Londyn" , quiz1),
                new Question("Włochy", "Rzym", quiz1)
        ));
        Quiz quiz2 = quizRepository.findById(2L).get();
        questionRepository.saveAll(Arrays.asList(
                new Question("Poniedziałek", "Monday", quiz2),
                new Question("Wtorek", "Tuesday", quiz2),
                new Question("Środa", "Wednesday", quiz2),
                new Question("Czwartek", "Thursday", quiz2),
                new Question("Piątek", "Friday", quiz2),
                new Question("Sobota", "Saturday", quiz2),
                new Question("Niedziela", "Sunday", quiz2)
        ));
        Quiz quiz3 = quizRepository.findById(3L).get();
        questionRepository.saveAll(Arrays.asList(
                new Question("Styczeń", "Januray", quiz3),
                new Question("Luty", "February", quiz3),
                new Question("Marzec", "March ", quiz3),
                new Question("Kwiecień", "April", quiz3),
                new Question("Maj", "May", quiz3),
                new Question("Czerwiec", "June", quiz3),
                new Question("Lipiec", "July", quiz3),
                new Question("Sierpień", "August", quiz3),
                new Question("Wrzesień", "September", quiz3),
                new Question("Październik", "October", quiz3),
                new Question("Listopad", "November", quiz3),
                new Question("Grudzień", "December", quiz3)
        ));
        //username: user
        //pass: 12345
        User user = new User();
        user.setUsername("user");
        user.setPassword("$2a$12$hlg1KLbR/C9jwpLFsZL.nOkpAk0FyAS08vDEluWF.j8tLBrORpk0e");
        user.setEmail("user@example.com");
        user.setRole(roleRepository.findRoleByName("USER"));
        user.setTier(tierRepository.findTierByTiername("PADAWAN"));
        userRepository.save(user);
        //username: admin
        //pass: 12345
        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword("$2a$12$hlg1KLbR/C9jwpLFsZL.nOkpAk0FyAS08vDEluWF.j8tLBrORpk0e");
        admin.setEmail("admin@example.com");
        admin.setRole(roleRepository.findRoleByName("ADMIN"));
        admin.setTier(tierRepository.findTierByTiername("PADAWAN"));
        userRepository.save(admin);
        //comment
    }
}
