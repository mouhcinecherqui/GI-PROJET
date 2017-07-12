import { AllPage } from './app.po';

describe('all App', () => {
  let page: AllPage;

  beforeEach(() => {
    page = new AllPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
