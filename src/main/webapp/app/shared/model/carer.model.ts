import { IVisit } from 'app/shared/model/visit.model';
import { IRota } from 'app/shared/model/rota.model';
import { IClient } from 'app/shared/model/client.model';
import { Days } from 'app/shared/model/enumerations/days.model';

export interface ICarer {
  id?: number;
  name?: string;
  phone?: number | null;
  daysavailable?: Days;
  visit?: IVisit | null;
  rota?: IRota | null;
  client?: IClient | null;
}

export const defaultValue: Readonly<ICarer> = {};
