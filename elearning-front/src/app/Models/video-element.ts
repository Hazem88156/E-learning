import { Member } from './member';

export class VideoElement {
  muted!: boolean;
  srcObject!: MediaStream;
  user!: Member;
}
