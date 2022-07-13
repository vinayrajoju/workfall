package com.workfall.utils;

import com.workfall.pages.clientpages.PartnersPage;


public class Pages {
public PartnersPage partnersPage;



    public PartnersPage viewAllPartners() {
        if (partnersPage == null) {
            partnersPage = new PartnersPage();
        }

        return partnersPage;
    }
}
