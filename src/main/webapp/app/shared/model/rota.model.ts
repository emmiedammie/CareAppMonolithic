import dayjs from 'dayjs';
import { ICarer } from 'app/shared/model/carer.model';
import { IVisit } from 'app/shared/model/visit.model';

export interface IRota {
  id?: number;
  client?: string;
  carer?: string;
  time?: string;
  duration?: string;
  carers?: ICarer[] | null;
  visit?: IVisit | null;
}

export const defaultValue: Readonly<IRota> = {};
