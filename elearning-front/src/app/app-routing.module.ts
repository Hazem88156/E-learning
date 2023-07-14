import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddMatieresComponent } from './components/assistant/add-matieres/add-matieres.component';
import { DetailEtudiantsComponent } from './components/assistant/detail-etudiants/detail-etudiants.component';
import { DetailProfesseursComponent } from './components/assistant/detail-professeurs/detail-professeurs.component';
import { ListEtudiantsComponent } from './components/assistant/list-etudiants/list-etudiants.component';
import { ListMatieresComponent } from './components/assistant/list-matieres/list-matieres.component';
import { ListProfesseursComponent } from './components/assistant/list-professeurs/list-professeurs.component';
import { ProfilesComponent } from './components/assistant/profiles/profiles.component';
import { UpdateMatieresComponent } from './components/assistant/update-matieres/update-matieres.component';
import { UpdateProfesseursComponent } from './components/assistant/update-professeurs/update-professeurs.component';
import { AddClasseComponent } from './components/classe/add-classe/add-classe.component';
import { ListClasseComponent } from './components/classe/list-classe/list-classe.component';
import { UpdateClasseComponent } from './components/classe/update-classe/update-classe.component';
import { AddCoursComponent } from './components/cours/add-cours/add-cours.component';

import { ListCourComponent } from './components/cours/list-cour/list-cour.component';
import { UpdateCourComponent } from './components/cours/update-cour/update-cour.component';
import { DashboardAdminComponent } from './components/dashboard-admin/dashboard-admin.component';
import { DashboardAssistantComponent } from './components/dashboard-assistant/dashboard-assistant.component';
import { DashboardProfesseurComponent } from './components/dashboard-professeur/dashboard-professeur.component';
import { DetailDocumentComponent } from './components/enseignant/detail-document/detail-document.component';
import { DocumentComponent } from './components/enseignant/document/document.component';
import { ListDocumentComponent } from './components/enseignant/list-document/list-document.component';
import { DetailEtudiantComponent } from './components/etudiant/detail-etudiant/detail-etudiant.component';
import { ListEtudaintComponent } from './components/etudiant/list-etudaint/list-etudaint.component';
import { UpdateEtudiantComponent } from './components/etudiant/update-etudiant/update-etudiant.component';
import { AddExamenComponent } from './components/examen/add-examen/add-examen.component';
import { LoginComponent } from './components/login/login.component';
import { AddMatiereComponent } from './components/matiere/add-matiere/add-matiere.component';
import { ListMatiereComponent } from './components/matiere/list-matiere/list-matiere.component';
import { UpdateMatiereComponent } from './components/matiere/update-matiere/update-matiere.component';
import { DetailProfesseurComponent } from './components/professeur/detail-professeur/detail-professeur.component';
import { ListProfesseurComponent } from './components/professeur/list-professeur/list-professeur.component';
import { UpdateProfesseurComponent } from './components/professeur/update-professeur/update-professeur.component';
import { ProfileComponent } from './components/profile/profile.component';
import { AddQuestionComponent } from './components/question/add-question/add-question.component';
import { WelcomeComponent } from './components/examen/welcome/welcome.component';

import { RegisterAdminComponent } from './components/register-admin/register-admin.component';
import { RegisterEtudiantComponent } from './components/register-etudiant/register-etudiant.component';
import { RegisterProfesseurComponent } from './components/register-professeur/register-professeur.component';
import { AddReunionComponent } from './components/reunion/add-reunion/add-reunion.component';
import { DashboardReunionComponent } from './components/reunion/dashboard-reunion/dashboard-reunion.component';
import { ListReunionComponent } from './components/reunion/list-reunion/list-reunion.component';
import { VedioBoxUserComponent } from './components/reunion/vedio-box-user/vedio-box-user.component';
import { TabdataComponent } from './components/tabdata/tabdata.component';
import { AddUserComponent } from './components/utilisateur/add-user/add-user.component';
import { DetailUserComponent } from './components/utilisateur/detail-user/detail-user.component';
import { EditUserComponent } from './components/utilisateur/edit-user/edit-user.component';
import { ListUserComponent } from './components/utilisateur/list-user/list-user.component';
import { AddVedioComponent } from './components/vedio/add-vedio/add-vedio.component';
import { DetailVedioComponent } from './components/vedio/detail-vedio/detail-vedio.component';
import { ListVedioComponent } from './components/vedio/list-vedio/list-vedio.component';
import { ZoomComponent } from './components/zoom/zoom.component';
import { PassExamenComponent } from './components/examen/pass-examen/pass-examen.component';
import { ListExamenComponent } from './components/examen/list-examen/list-examen.component';
import { DashbordEtudiantComponent } from './components/dashbord-etudiant/dashbord-etudiant.component';
import { CoursDocumentComponent } from './components/cours/cours-document/cours-document.component';
import { CoursVideoComponent } from './components/cours/cours-video/cours-video.component';
import { CoursDocumentVedioComponent } from './components/cours/cours-document-vedio/cours-document-vedio.component';
import { CoursExamenComponent } from './components/cours/cours-examen/cours-examen.component';
import { ProfileProfesseurComponent } from './components/profile-professeur/profile-professeur.component';
import { ProfileEtudiantComponent } from './components/profile-etudiant/profile-etudiant.component';
import { AddClassesComponent } from './components/assistant/classe/add-classes/add-classes.component';
import { ListCoursComponent } from './components/assistant/cours/list-cours/list-cours.component';
import { UpdateClassesComponent } from './components/assistant/classe/update-classes/update-classes.component';
import { UpdateCoursComponent } from './components/assistant/cours/update-cours/update-cours.component';
import { AddCourComponent } from './components/assistant/cours/add-cour/add-cour.component';
import { ListClassesComponent } from './components/assistant/classe/list-classes/list-classes.component';
import { JitsiComponent } from './components/jitsi/jitsi.component';
import { ThankYouComponent } from './components/thank-you/thank-you.component';

const routes: Routes = [
  { path: 'dashboradadmin', component: DashboardAdminComponent },
  { path: 'dashboardassistant', component: DashboardAssistantComponent },
  { path: '', component: LoginComponent },
  { path: 'login', component: LoginComponent },
  { path: 'registeradmin', component: RegisterAdminComponent },
  { path: 'registeretudiant', component: RegisterEtudiantComponent },
  { path: 'registerprofesseur', component: RegisterProfesseurComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'tabdata', component: TabdataComponent },
  { path: 'edit-user', component: EditUserComponent },
  { path: 'add-user', component: AddUserComponent },
  { path: 'list-user', component: ListUserComponent },
  { path: 'list-professeur', component: ListProfesseurComponent },
  { path: 'edit-professeur/:id', component: UpdateProfesseurComponent },
  { path: 'list-etudiant', component: ListEtudaintComponent },
  { path: 'edit-etudiant/:id', component: UpdateEtudiantComponent },
  { path: 'add-matiere', component: AddMatiereComponent },
  { path: 'list-matiere', component: ListMatiereComponent },
  { path: 'update-matiere', component: UpdateMatiereComponent },
  { path: 'detail-professeur', component: DetailProfesseurComponent },
  { path: 'detail-etudiant', component: DetailEtudiantComponent },
  { path: 'detail-utilisateur', component: DetailUserComponent },
  { path: 'add-classe', component: AddClasseComponent },
  { path: 'list-classe', component: ListClasseComponent },
  { path: 'update-classe', component: UpdateClasseComponent },
  { path: 'add-matiere-assistant', component: AddMatieresComponent },
  { path: 'update-matiere-assistant', component: UpdateMatieresComponent },
  { path: 'list-matiere-assistant', component: ListMatieresComponent },
  { path: 'list-etudiant-assistant', component: ListEtudiantsComponent },
  { path: 'update-etudiant-assistant', component: UpdateProfesseursComponent },
  { path: 'detail-etudiant-assistant', component: DetailEtudiantsComponent },
  { path: 'list-professeur-assistant', component: ListProfesseursComponent },
  { path: 'add-cours', component: AddCoursComponent },
  { path: 'add-cour', component: AddCourComponent },
  { path: 'list-cour', component: ListCourComponent },
  { path: 'add-document', component: DocumentComponent },
  { path: 'list-document', component: ListDocumentComponent },
  { path: 'detail-document/:id', component: DetailDocumentComponent },
  { path: 'add-vedio', component: AddVedioComponent },
  { path: 'list-vedio', component: ListVedioComponent },
  { path: 'detail-vedio/:id', component: DetailVedioComponent },
  { path: 'update-cour/:id', component: UpdateCourComponent },
  { path: 'add-reunion', component: AddReunionComponent },
  { path: 'list-reunion', component: ListReunionComponent },
  { path: 'dashboardreunion/:id', component: DashboardReunionComponent },
  { path: 'vedio-box', component: VedioBoxUserComponent },
  { path: 'zoom', component: ZoomComponent },
  { path: 'add-question', component: AddQuestionComponent },
  { path: 'add-examen', component: AddExamenComponent },
  { path: 'welcome/:id', component: WelcomeComponent },
  { path: 'pass-examen/:id', component: PassExamenComponent },
  { path: 'list-examen', component: ListExamenComponent },
  { path: 'dashboardetudiant', component: DashbordEtudiantComponent },
  { path: 'coursDocument/:id', component: CoursDocumentComponent },
  { path: 'coursExamen/:id', component: CoursExamenComponent },
  { path: 'coursVideo/:id', component: CoursVideoComponent },
  { path: 'coursDocumentVedio/:id', component: CoursDocumentVedioComponent },
  { path: 'profile-professeur', component: ProfileProfesseurComponent },
  {
    path: 'update-professeur-assistant',
    component: UpdateProfesseursComponent,
  },
  { path: 'zoom', component: ZoomComponent },
  { path: 'profile-assistant', component: ProfilesComponent },
  {
    path: 'detail-professeur-assistant',
    component: DetailProfesseursComponent,
  },
  { path: 'profile-etudiant', component: ProfileEtudiantComponent },
  { path: 'dashboardprofesseur', component: DashboardProfesseurComponent },
  { path: 'dashboard-etudiant', component: DashbordEtudiantComponent },
  { path: 'add-classes', component: AddClassesComponent },
  { path: 'list-classes', component: ListClassesComponent },
  { path: 'update-classes', component: UpdateClassesComponent },
  { path: 'add-cour', component: AddCoursComponent },
  { path: 'list-cours', component: ListCoursComponent },
  { path: 'update-cours/:id', component: UpdateCoursComponent },
  { path: 'jitsi/:id', component: JitsiComponent },
  { path: 'thank-you', component: ThankYouComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
