$(document).ready(function () {
    var home=$("#nav-home-tab");
    var profile=$("#nav-profile-tab");
    var contact=$("#nav-contact-tab");
    var no3=$(".no3");
    var no2=$(".no2");
    // profile.hide();
    // contact.hide();
    contact.click(function () {
        home.hide();
        profile.hide();
        contact.show();
    });
    home.click(function () {
        no2.html("");
        no3.html("");
        home.show();
    });
    contact.click(function () {
        profile.hide();
        home.hide();
        contact.show();
    })
});