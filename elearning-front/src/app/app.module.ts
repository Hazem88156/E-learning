import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { DashboardAdminComponent } from './components/dashboard-admin/dashboard-admin.component';
import { RegisterAdminComponent } from './components/register-admin/register-admin.component';
import { RegisterEtudiantComponent } from './components/register-etudiant/register-etudiant.component';
import { RegisterProfesseurComponent } from './components/register-professeur/register-professeur.component';
import { ProfileComponent } from './components/profile/profile.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { TabdataComponent } from './components/tabdata/tabdata.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { DataTablesModule } from 'angular-datatables';
import { SidbarAdminComponent } from './components/sidbar-admin/sidbar-admin.component';
import { SidbarProfesseurComponent } from './components/sidbar-professeur/sidbar-professeur.component';
import { SidbarEtudiantComponent } from './components/sidbar-etudiant/sidbar-etudiant.component';
import { DashbordEtudiantComponent } from './components/dashbord-etudiant/dashbord-etudiant.component';
import { TokenInterceptor } from './interceptors/TokenInterceptor';
import { ErrorInterceptor } from './interceptors/ErrorInterceptor';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AddUserComponent } from './components/utilisateur/add-user/add-user.component';
import { ListUserComponent } from './components/utilisateur/list-user/list-user.component';
import { EditUserComponent } from './components/utilisateur/edit-user/edit-user.component';
import { ListProfesseurComponent } from './components/professeur/list-professeur/list-professeur.component';
import { ListEtudaintComponent } from './components/etudiant/list-etudaint/list-etudaint.component';
import { AddMatiereComponent } from './components/matiere/add-matiere/add-matiere.component';
import { ListMatiereComponent } from './components/matiere/list-matiere/list-matiere.component';
import { UpdateMatiereComponent } from './components/matiere/update-matiere/update-matiere.component';
import { UpdateEtudiantComponent } from './components/etudiant/update-etudiant/update-etudiant.component';
import { UpdateProfesseurComponent } from './components/professeur/update-professeur/update-professeur.component';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { DetailProfesseurComponent } from './components/professeur/detail-professeur/detail-professeur.component';
import { DetailEtudiantComponent } from './components/etudiant/detail-etudiant/detail-etudiant.component';
import { DetailUserComponent } from './components/utilisateur/detail-user/detail-user.component';
import { AddClasseComponent } from './components/classe/add-classe/add-classe.component';
import { ListClasseComponent } from './components/classe/list-classe/list-classe.component';
import { UpdateClasseComponent } from './components/classe/update-classe/update-classe.component';
import { SidbarAssistantComponent } from './components/sidbar-assistant/sidbar-assistant.component';
import { DashboardAssistantComponent } from './components/dashboard-assistant/dashboard-assistant.component';
import { DetailProfesseursComponent } from './components/assistant/detail-professeurs/detail-professeurs.component';
import { ListProfesseursComponent } from './components/assistant/list-professeurs/list-professeurs.component';
import { UpdateProfesseursComponent } from './components/assistant/update-professeurs/update-professeurs.component';
import { UpdateEtudiantsComponent } from './components/assistant/update-etudiants/update-etudiants.component';
import { DetailEtudiantsComponent } from './components/assistant/detail-etudiants/detail-etudiants.component';
import { ListEtudiantsComponent } from './components/assistant/list-etudiants/list-etudiants.component';
import { ListMatieresComponent } from './components/assistant/list-matieres/list-matieres.component';
import { AddMatieresComponent } from './components/assistant/add-matieres/add-matieres.component';
import { UpdateMatieresComponent } from './components/assistant/update-matieres/update-matieres.component';
import { ProfilesComponent } from './components/assistant/profiles/profiles.component';
import { HeaderAssistantComponent } from './header-assistant/header-assistant.component';
import { NgxPaginationModule } from 'ngx-pagination';
import { Ng2OrderModule } from 'ng2-order-pipe';
import { DashboardProfesseurComponent } from './components/dashboard-professeur/dashboard-professeur.component';
import { DocumentComponent } from './components/enseignant/document/document.component';
import { AddCoursComponent } from './components/cours/add-cours/add-cours.component';
import { ListCourComponent } from './components/cours/list-cour/list-cour.component';
import { ListDocumentComponent } from './components/enseignant/list-document/list-document.component';
import { DetailDocumentComponent } from './components/enseignant/detail-document/detail-document.component';
import { PdfViewerModule } from 'ng2-pdf-viewer';
import { AddVedioComponent } from './components/vedio/add-vedio/add-vedio.component';
import { ListVedioComponent } from './components/vedio/list-vedio/list-vedio.component';
import { DetailVedioComponent } from './components/vedio/detail-vedio/detail-vedio.component';
import { UpdateCourComponent } from './components/cours/update-cour/update-cour.component';
import { AddReunionComponent } from './components/reunion/add-reunion/add-reunion.component';
import { ListReunionComponent } from './components/reunion/list-reunion/list-reunion.component';
import { VedioBoxUserComponent } from './components/reunion/vedio-box-user/vedio-box-user.component';
import { DashboardReunionComponent } from './components/reunion/dashboard-reunion/dashboard-reunion.component';
import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { ZoomComponent } from './components/zoom/zoom.component';
import { AddQuestionComponent } from './components/question/add-question/add-question.component';
import { AddExamenComponent } from './components/examen/add-examen/add-examen.component';
import { WelcomeComponent } from './components/examen/welcome/welcome.component';
import { PassExamenComponent } from './components/examen/pass-examen/pass-examen.component';
import { ListExamenComponent } from './components/examen/list-examen/list-examen.component';
import { CoursDocumentComponent } from './components/cours/cours-document/cours-document.component';
import { CoursVideoComponent } from './components/cours/cours-video/cours-video.component';
import { CoursDocumentVedioComponent } from './components/cours/cours-document-vedio/cours-document-vedio.component';
import { CoursExamenComponent } from './components/cours/cours-examen/cours-examen.component';
import { ProfileProfesseurComponent } from './components/profile-professeur/profile-professeur.component';
import { ProfileEtudiantComponent } from './components/profile-etudiant/profile-etudiant.component';
import { AddClassesComponent } from './components/assistant/classe/add-classes/add-classes.component';
import { ListClassesComponent } from './components/assistant/classe/list-classes/list-classes.component';
import { UpdateClassesComponent } from './components/assistant/classe/update-classes/update-classes.component';
import { UpdateCoursComponent } from './components/assistant/cours/update-cours/update-cours.component';
import { ListCoursComponent } from './components/assistant/cours/list-cours/list-cours.component';
import { AddCourComponent } from './components/assistant/cours/add-cour/add-cour.component';
import { JitsiComponent } from './components/jitsi/jitsi.component';
import { ThankYouComponent } from './components/thank-you/thank-you.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    DashboardAdminComponent,
    RegisterAdminComponent,
    RegisterEtudiantComponent,
    RegisterProfesseurComponent,
    ProfileComponent,
    HeaderComponent,
    FooterComponent,
    TabdataComponent,
    SidbarAdminComponent,
    SidbarProfesseurComponent,
    SidbarEtudiantComponent,
    DashbordEtudiantComponent,
    AddUserComponent,
    ListUserComponent,
    EditUserComponent,
    ListProfesseurComponent,
    ListEtudaintComponent,
    AddMatiereComponent,
    ListMatiereComponent,
    UpdateMatiereComponent,
    UpdateEtudiantComponent,
    UpdateProfesseurComponent,
    DetailProfesseurComponent,
    DetailEtudiantComponent,
    DetailUserComponent,
    AddClasseComponent,
    ListClasseComponent,
    UpdateClasseComponent,
    SidbarAssistantComponent,
    DashboardAssistantComponent,
    DetailProfesseursComponent,
    ListProfesseursComponent,
    UpdateProfesseursComponent,
    UpdateEtudiantsComponent,
    DetailEtudiantsComponent,
    ListEtudiantsComponent,
    ListMatieresComponent,
    AddMatieresComponent,
    UpdateMatieresComponent,
    ProfilesComponent,
    HeaderAssistantComponent,
    DashboardProfesseurComponent,
    DocumentComponent,
    AddCoursComponent,
    ListCourComponent,
    ListDocumentComponent,
    DetailDocumentComponent,
    AddVedioComponent,
    ListVedioComponent,
    DetailVedioComponent,
    UpdateCourComponent,
    AddReunionComponent,
    ListReunionComponent,
    VedioBoxUserComponent,
    DashboardReunionComponent,
    ZoomComponent,
    AddQuestionComponent,
    AddExamenComponent,
    WelcomeComponent,
    PassExamenComponent,
    ListExamenComponent,
    CoursDocumentComponent,
    CoursVideoComponent,
    CoursDocumentVedioComponent,
    CoursExamenComponent,
    ProfileProfesseurComponent,
    ProfileEtudiantComponent,
    AddClassesComponent,
    ListClassesComponent,
    UpdateClassesComponent,
    UpdateCoursComponent,
    ListCoursComponent,
    AddCourComponent,
    JitsiComponent,
    ThankYouComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    DataTablesModule,
    ReactiveFormsModule,
    HttpClientModule,
    NgbModule,
    NgxPaginationModule,
    Ng2OrderModule,
    PdfViewerModule,
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptor,
      multi: true,
    },
    {
      provide: HTTP_INTERCEPTORS,
      useClass: ErrorInterceptor,
      multi: true,
    },
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
