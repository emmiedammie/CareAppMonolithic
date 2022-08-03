import React, { useEffect } from 'react';
import { Link, useParams } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import { Translate, TextFormat } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { DurationFormat } from 'app/shared/DurationFormat';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { getEntity } from './visit.reducer';

export const VisitDetail = () => {
  const dispatch = useAppDispatch();

  const { id } = useParams<'id'>();

  useEffect(() => {
    dispatch(getEntity(id));
  }, []);

  const visitEntity = useAppSelector(state => state.visit.entity);
  return (
    <Row>
      <Col md="8">
        <h2 data-cy="visitDetailsHeading">
          <Translate contentKey="careAppMonoApp.visit.detail.title">Visit</Translate>
        </h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="id">
              <Translate contentKey="global.field.id">ID</Translate>
            </span>
          </dt>
          <dd>{visitEntity.id}</dd>
          <dt>
            <span id="client">
              <Translate contentKey="careAppMonoApp.visit.client">Client</Translate>
            </span>
          </dt>
          <dd>{visitEntity.client}</dd>
          <dt>
            <span id="address">
              <Translate contentKey="careAppMonoApp.visit.address">Address</Translate>
            </span>
          </dt>
          <dd>{visitEntity.address}</dd>
          <dt>
            <span id="carer">
              <Translate contentKey="careAppMonoApp.visit.carer">Carer</Translate>
            </span>
          </dt>
          <dd>{visitEntity.carer}</dd>
          <dt>
            <span id="accesscode">
              <Translate contentKey="careAppMonoApp.visit.accesscode">Accesscode</Translate>
            </span>
          </dt>
          <dd>{visitEntity.accesscode}</dd>
          <dt>
            <span id="timein">
              <Translate contentKey="careAppMonoApp.visit.timein">Timein</Translate>
            </span>
          </dt>
          <dd>{visitEntity.timein ? <TextFormat value={visitEntity.timein} type="date" format={APP_DATE_FORMAT} /> : null}</dd>
          <dt>
            <span id="status">
              <Translate contentKey="careAppMonoApp.visit.status">Status</Translate>
            </span>
          </dt>
          <dd>{visitEntity.status}</dd>
          <dt>
            <span id="timespent">
              <Translate contentKey="careAppMonoApp.visit.timespent">Timespent</Translate>
            </span>
          </dt>
          <dd>
            {visitEntity.timespent ? <DurationFormat value={visitEntity.timespent} /> : null} ({visitEntity.timespent})
          </dd>
          <dt>
            <Translate contentKey="careAppMonoApp.visit.rota">Rota</Translate>
          </dt>
          <dd>{visitEntity.rota ? visitEntity.rota.id : ''}</dd>
          <dt>
            <Translate contentKey="careAppMonoApp.visit.carer">Carer</Translate>
          </dt>
          <dd>{visitEntity.carer ? visitEntity.carer.id : ''}</dd>
          <dt>
            <Translate contentKey="careAppMonoApp.visit.client">Client</Translate>
          </dt>
          <dd>{visitEntity.client ? visitEntity.client.name : ''}</dd>
        </dl>
        <Button tag={Link} to="/visit" replace color="info" data-cy="entityDetailsBackButton">
          <FontAwesomeIcon icon="arrow-left" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.back">Back</Translate>
          </span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/visit/${visitEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.edit">Edit</Translate>
          </span>
        </Button>
      </Col>
    </Row>
  );
};

export default VisitDetail;
