package com.project_javaee.java_ee.controller;

import com.project_javaee.java_ee.model.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ViewController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/register")
    public ModelAndView showRegisterPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register");
        return modelAndView;
    }

    @GetMapping("/login")
    public ModelAndView showLoginPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @GetMapping("/dashboard")
    public ModelAndView showDashboardPage(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        User user = (User) session.getAttribute("user");
        modelAndView.addObject("user", user);
        modelAndView.setViewName("dashboard");
        return modelAndView;
    }

    @GetMapping("/userdashboard")
    public ModelAndView showDashboardUserPage(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        User user = (User) session.getAttribute("user");
        modelAndView.addObject("user", user);
        modelAndView.setViewName("user/dashboard");
        return modelAndView;
    }

    @GetMapping("/room")
    public ModelAndView showRoomPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("room");
        return modelAndView;
    }

    @GetMapping("/userroom")
    public ModelAndView showRoomUserPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/room");
        return modelAndView;
    }

    @GetMapping("/surat")
    public ModelAndView showSuratPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("surat");
        return modelAndView;
    }

    @GetMapping("/usersurat")
    public ModelAndView showSuratUserPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/surat");
        return modelAndView;
    }

    @GetMapping("/izin")
    public ModelAndView showIzinKeluarPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("izinKeluar");
        return modelAndView;
    }

    @GetMapping("/userizin")
    public ModelAndView showIzinKeluarUserPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/izinKeluar");
        return modelAndView;
    }

    @GetMapping("/izinbermalam")
    public ModelAndView showIzinBermalamPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("izinBermalam");
        return modelAndView;
    }

    @GetMapping("/userizinbermalam")
    public ModelAndView showIzinBermalamUserPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/izinBermalam");
        return modelAndView;
    }

    @GetMapping("/pembeliankaos")
    public ModelAndView showPembelianKaosPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("pembelianKaos");
        return modelAndView;
    }

    @GetMapping("/userpembeliankaos")
    public ModelAndView showPembelianKaosUserPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/pembelianKaos");
        return modelAndView;
    }

    @GetMapping("/userhistoryroom")
    public ModelAndView showHistoryRoomUserPage() {
        ModelAndView modelAndView = new ModelAndView();

        List<Booking> bookings = restTemplate.getForObject("http://localhost:8080/api/room/list", List.class);
        modelAndView.addObject("bookings", bookings);

        modelAndView.setViewName("user/historyroom");
        return modelAndView;
    }

    @GetMapping("/userhistoryizinkeluar")
    public ModelAndView showHistoryIKUserPage() {
        ModelAndView modelAndView = new ModelAndView();

        List<IzinKeluar> izinKeluars = restTemplate.getForObject("http://localhost:8080/api/izin-keluar/list", List.class);
        modelAndView.addObject("izinKeluars", izinKeluars);

        modelAndView.setViewName("user/historyizinkeluar");
        return modelAndView;
    }

    @GetMapping("/userhistoryizinbermalam")
    public ModelAndView showHistoryIBUserPage() {
        ModelAndView modelAndView = new ModelAndView();

        List<IzinBermalam> izinBermalams = restTemplate.getForObject("http://localhost:8080/api/izin-bermalam/list", List.class);
        modelAndView.addObject("izinBermalams", izinBermalams);

        modelAndView.setViewName("user/historyizinbermalam");
        return modelAndView;
    }

    @GetMapping("/userhistorysurat")
    public ModelAndView showHistorySuratUserPage() {
        ModelAndView modelAndView = new ModelAndView();

        List<Surat> surats = restTemplate.getForObject("http://localhost:8080/api/surat/list", List.class);
        modelAndView.addObject("surats", surats);

        modelAndView.setViewName("user/historysurat");
        return modelAndView;
    }

    @GetMapping("/userhistorypembelian")
    public ModelAndView showHistoryPembelianUserPage() {
        ModelAndView modelAndView = new ModelAndView();

        List<Pembelian> pembelians = restTemplate.getForObject("http://localhost:8080/pembelian/list", List.class);
        modelAndView.addObject("pembelians", pembelians);

        modelAndView.setViewName("user/historypembelian");
        return modelAndView;
    }

    @GetMapping("/historyroom")
    public ModelAndView showHistoryRoomPage() {
        ModelAndView modelAndView = new ModelAndView();

        List<Booking> bookings = restTemplate.getForObject("http://localhost:8080/api/room/list", List.class);
        modelAndView.addObject("bookings", bookings);

        modelAndView.setViewName("historyroom");
        return modelAndView;
    }

    @GetMapping("/historyizinkeluar")
    public ModelAndView showHistoryIKPage() {
        ModelAndView modelAndView = new ModelAndView();

        List<IzinKeluar> izinKeluars = restTemplate.getForObject("http://localhost:8080/api/izin-keluar/list", List.class);
        modelAndView.addObject("izinKeluars", izinKeluars);

        modelAndView.setViewName("historyizinkeluar");
        return modelAndView;
    }

    @GetMapping("/historyizinbermalam")
    public ModelAndView showHistoryIBPage() {
        ModelAndView modelAndView = new ModelAndView();

        List<IzinBermalam> izinBermalams = restTemplate.getForObject("http://localhost:8080/api/izin-bermalam/list", List.class);
        modelAndView.addObject("izinBermalams", izinBermalams);

        modelAndView.setViewName("historyizinbermalam");
        return modelAndView;
    }

    @GetMapping("/historysurat")
    public ModelAndView showHistorySuratPage() {
        ModelAndView modelAndView = new ModelAndView();

        List<Surat> surats = restTemplate.getForObject("http://localhost:8080/api/surat/list", List.class);
        modelAndView.addObject("surats", surats);

        modelAndView.setViewName("historysurat");
        return modelAndView;
    }

    @GetMapping("/historypembelian")
    public ModelAndView showHistoryPembelianPage() {
        ModelAndView modelAndView = new ModelAndView();

        List<Pembelian> pembelians = restTemplate.getForObject("http://localhost:8080/pembelian/list", List.class);
        modelAndView.addObject("pembelians", pembelians);

        modelAndView.setViewName("historypembelian");
        return modelAndView;
    }

    @GetMapping("/logout")
    public ModelAndView logout() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }
}
